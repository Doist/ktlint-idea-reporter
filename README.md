> **Warning** — Not actively maintained.

# Ktlint IDEA Reporter

This [reporter](https://github.com/pinterest/ktlint#creating-a-reporter) improves [ktlint](https://github.com/pinterest/ktlint) output for better integration with IntelliJ IDEA based IDE.

## Usage

```shell
ktlint --reporter=idea,artifact=/path/to/ktlint-idea-reporter-1.0.0.jar
```

## Release

To release a new version, ensure `CHANGELOG.md` is up-to-date, and push the corresponding tag (e.g., `v1.2.3`). GitHub Actions handles the rest.

## Licence

Released under the [MIT License](https://opensource.org/licenses/MIT).
