#!/bin/bash

latest_commit_message=$(git log -1 --pretty=%B)
patch_beginning_regex="^[F|f]ix|^bugfix:|^[F|f]ixes|^[F|f]ixed"
minor_beginning_regex="^[A|a]dd|^[F|f]eat|^[U|u]pdate|^[R|r]emove|^[D|d]elete|^[I|i]mplement|^[C|c]reate"

# Prioritize explicit bump requests
if echo "$latest_commit_message" | grep -q "^Bump: minor"; then
  echo "minor"
  exit 0
elif echo "$latest_commit_message" | grep -q "^Bump: patch"; then
  echo "patch"
  exit 0
fi

# Check the beginning of the commit message
if [[ $latest_commit_message =~ $patch_beginning_regex ]]; then
  echo "patch"
elif [[ $latest_commit_message =~ $minor_beginning_regex ]]; then
  echo "minor"
else
  echo "patch"
fi
