# ShamaSchizm — NeoForge 26.2

This is the NeoForge port targeting Minecraft **26.2** and NeoForge **26.2.0.75** (Java 25).

Build with `./gradlew build`. The optional dedicated-server regression suite runs with
`./gradlew runVerificationServer`.

Key migration/fixes:

- Souls are persistent player data, survive death/clone/reconnect, preserve a real zero, and migrate old Forge data.
- Shaman entities are persistent, non-pushable, and retain their offers.
- Shaman soul trades use server-authoritative virtual currency; ghost soul entries cannot be taken as items.
- The ancient blueprint is a smithing upgrade for compatible vanilla or modded equipment. It sets a persistent enchantability-cap component, and the anvil handler permits enchantments through level X.
- Schizm portal links are saved per source portal, use an explicit 8:1 coordinate conversion, and generate the canonical room once without overwriting edits.

The original Forge project is not modified; this directory is the converted project.
