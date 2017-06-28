#!/usr/bin/env bash

set -eo pipefail

readonly PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd -P)"

infofln() {
  local fmt="$1"; shift
  printf "\033[2;39;49m%s \033[0;34m INFO\033[2;39;49m : \033[0m${fmt}\n" \
         "$(date "+%Y-%m-%d %H:%M:%S")" \
         "$@"
}

__readme_sed() {
  sed -e "$1" "${PROJECT_DIR}/README.md" >"${PROJECT_DIR}/README.md.new"
  mv "${PROJECT_DIR}/README.md.new" "${PROJECT_DIR}/README.md"
}

update_readme_version() {
  __readme_sed "s#<version>.*</version>#<version>$1</version>#"
  __readme_sed "s/logback:logback-ext:[^']*'$/logback:logback-ext:$1'/"
}

main() {
  if [[ "$#" -lt "1" ]]; then
    printf >&2 "Usage: %s <version>\n" "$0"
    return 1
  fi

  local version="$1"

  cd "${PROJECT_DIR}"

  infofln "Cleaning project..."
  mvn --quiet clean

  infofln "Setting new version: %s..." "${version}"
  mvn --quiet versions:set -DnewVersion="${version}"
  update_readme_version "${version}"

  infofln "Committing to Git and pushing to remote..."
  git add pom.xml
  git commit --quiet --message="Version ${version}"
  git push --quiet origin master

  infofln "Creating and pushing tag..."
  mvn --quiet scm:tag

  infofln "Deploying..."
  mvn --quiet deploy

  infofln "Done."
}

main "$@"
