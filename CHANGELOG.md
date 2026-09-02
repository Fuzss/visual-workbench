# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v21.1.2-1.21.1] - 2026-09-02

### Added

- Add full support for the [EMI](https://modrinth.com/mod/emi) mod thanks to [Dykmoby](https://github.com/Dykmoby)
- This only concerns cases where both EMI & JEI are installed; EMI on its own was already working fine

### Changed

- Existing crafting tables are no longer replaced during world generation
- Instead, the behavior from newer versions where crafting tables are converted when clicked on has been backported
- Blocks from the [Furniture](https://modrinth.com/mod/lets-do-furniture) mod are now included by default in the
  `visualworkbench:unaltered_workbenches` block tag

### Fixed

- Fix generated fletching and smithing tables (e.g. in villages) behaving like modded crafting tables

### Changed

## [v21.1.1-1.21.1] - 2025-07-22

### Changed

- Add some simple hopper behavior for inserting items, also disable extracting items to prevent a dupe glitch

## [v21.1.0-1.21.1] - 2024-09-11

### Changed

- Update to Minecraft 1.21.1
