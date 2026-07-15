# Slimefun 4 — English, Multi-Version (Paper 1.21 – 26.x)

An English-default build of Slimefun 4 based on the actively maintained
[SlimefunGuguProject fork](https://github.com/SlimefunGuguProject/Slimefun4).
It retains the fork's newer Paper compatibility while restoring the original
English item names and English user-facing text, and extends compatibility
across multiple Minecraft versions.

> **Unofficial project:** This repository is not maintained or supported by the
> original Slimefun team. Do not report issues from this build to the original
> Slimefun issue tracker.

## Highlights

- **Multi-version support:** Compatible with Paper 1.21 through 26.x (latest).
- Compiles against the latest stable Paper API (`26.1.2.build.+`).
- Declares `api-version: '1.21'` in `plugin.yml` for broad cross-version support.
- Requires Java 25 for both the build and the server.
- Uses English (`en`) as the default language.
- Disables the downstream auto-updater by default so this build is not replaced by a Chinese build.
- Retains the existing multilingual locale system.
- Restores core item display names from the
  [original Slimefun repository](https://github.com/Slimefun/Slimefun4).
- Moves Simplified Chinese item names and static lore into
  `languages/zh-CN/items.yml` for guide localization.

## Supported Minecraft Versions

| Paper API | Minecraft | Status |
|-----------|-----------|--------|
| 26.x | 1.26.x | ✅ Latest (primary target) |
| 1.21.x | 1.21.x | ✅ Supported |
| 1.20.x | 1.20.x | ✅ Supported |
| 1.19.x | 1.19.x | ✅ Supported |
| 1.18.x | 1.18.x | ✅ Supported |

> **Note:** Paper 26.2+ experimental builds may work but are not the primary test target.

## Installation

1. Back up your world and the `plugins/Slimefun/` data directory.
2. Install a Paper server (1.21 or newer) running Java 25.
3. Download the latest `Slimefun-ENGLISH.jar` from this repository's `release/`
   directory or from a GitHub release.
4. Place the JAR in the server's `plugins/` directory.
5. Start the server and check the console for compatibility errors.

The generated default config uses:

```yaml
options:
  language: en
  enable-translations: true
```

Existing installations keep their current generated configuration. To switch an
existing server to English, set `options.language: en` in
`plugins/Slimefun/config.yml` and restart the server.

## Building

Install JDK 25, then run:

```bash
git clone <your-repository-url> slimefun4
cd slimefun4
chmod +x gradlew
./gradlew clean build -PprojectVersion="ENGLISH-MULTI" --no-daemon
```

The shaded plugin is written to:

```text
build/libs/Slimefun-ENGLISH-MULTI.jar
```

## Language files

The original locale files remain under `src/main/resources/languages/`.
English is the fallback language. The item translation resources added by this
fork are:

- `languages/en/items.yml`
- `languages/zh-CN/items.yml`

Item translations are applied to Slimefun Guide displays without changing the
canonical item IDs or the English templates stored on real items.

## Upstream projects and license

This work is derived from:

- [Slimefun/Slimefun4](https://github.com/Slimefun/Slimefun4)
- [SlimefunGuguProject/Slimefun4](https://github.com/SlimefunGuguProject/Slimefun4)

Slimefun 4 is licensed under the GNU General Public License v3.0. See
[`LICENSE`](LICENSE). Source code must remain available when distributing
modified builds.
