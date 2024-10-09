# How?
Some features that this has:
- Developer team merges to `development` (from `v0.1.0-alpha`):
  - If it's a feature PR, it bumps the minor version (to `v0.2.0-alpha`),
  - If it's a bugfix PR, it bumps the patch version (to `v0.1.1-alpha`)
 
For major releases and phases:
  - There is a manual GHA for bumping the major and phase version (to `v1.0.0-alpha` or `v0.1.0-beta`)

# Pros
- The development team, when developing minor or patch changes (casual work) they don't have to think about versoning as it is handled by the GHA in the cloud.
- Git is the single source of truth, no divergent version strings.
- Allows developers to effortlessly include version string inside the app.
- No unnecessary cluttering of the git commit history with "Bump commits"
- Everything is customizable and open-source which gives the development team total control over how version bumping happens.
- Based on [bump-my-version](https://github.com/callowayproject/bump-my-version/) which is actively maintained.
