# Verification report

`compileJava` and `build` completed successfully with the generated NeoForge 26.2 artifacts.

`runVerificationServer` completed successfully: **65 checks passed**. Coverage includes soul initialization/zero persistence/death/reconnect/legacy migration/healing, shaman persistence and saved offers, secure virtual trades, blueprint acceptance and component preservation on foreign equipment, anvil enchantment level X, Schizm scaling/room generation/return links/no-overwrite behavior, and SavedData serialization.

An interactive client smoke run was not available in the build container because its X server lacks the required keyboard/font support; client-only verification code is excluded from the distributable jar.
