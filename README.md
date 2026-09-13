# No Bars Connect — Meshtastic

No Bars Connect is the No Bars Club Meshtastic companion app, built from the open source SocialMesh project.

It is designed for off grid Meshtastic communication, device management, mapping, node discovery, messaging, telemetry, TAK workflows, waypoints, routing and other mesh tools while keeping a No Bars Club visual identity.

## Project status

This repository is the **Meshtastic side** of the larger No Bars Connect project.

- **Meshtastic:** this repository, based on SocialMesh
- **MeshCore:** `nobarsclubofficial/No-Bars-Connect-MeshCore`
- **Future unified experience:** No Bars Connect will provide a startup choice between Meshtastic and MeshCore while keeping each protocol separate underneath.

## No Bars Club branding

The branded client uses the No Bars Club website palette:

- Background: `#080B0A`
- Panel: `#0F1412`
- Secondary panel: `#141B18`
- Primary text: `#EEE9DC`
- Muted text: `#9AA8A0`
- Primary accent: `#9A6F35`
- Secondary accent: `#7F8F6A`
- Border: `#253129`
- Danger: `#FF5B67`

Website: https://www.nobarsclub.com

## Upstream and licensing

This project is a modified fork of **SocialMesh** by gotnull:

https://github.com/gotnull/socialmesh

SocialMesh is licensed under the GNU General Public License v3.0 or later. No Bars Connect preserves the upstream copyright and license notices and makes the corresponding modified source available under the same license terms.

Meshtastic is a separate open source project. Compatibility with Meshtastic does not imply ownership of, endorsement by, or affiliation with the Meshtastic project or its trademarks.

## Important backend note

The upstream SocialMesh client contains optional integrations with hosted services such as Firebase, RevenueCat, Stripe and account/cloud features. No Bars Connect must not depend on upstream production accounts. Those integrations are being audited, disabled, or replaced for the No Bars build while local radio communication and offline functionality are preserved.

## Development direction

The first branded release focuses on:

1. No Bars Connect product name and visual identity
2. Android and iOS app identity and icons
3. Website matched dark theme
4. Preserving BLE, USB and local Meshtastic operation
5. Preserving messaging, nodes, maps, telemetry, device configuration and TAK functionality
6. Replacing or disabling upstream hosted service dependencies before public distribution
7. Keeping upstream GPL attribution and source compliance intact

## Build

This remains a Flutter project. Follow the upstream SocialMesh build requirements until No Bars specific build documentation is completed.

---

**No Bars Connect**  
A No Bars Club project  
https://www.nobarsclub.com
