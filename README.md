# No Bars Command — Meshtastic

**Off Grid Communications Platform**

No Bars Command is the No Bars Club field communications platform. This repository is the Meshtastic side, built from the open source SocialMesh project and reworked around the No Bars Club brand.

It is designed for off grid communication, device management, mapping, node discovery, messaging, telemetry, TAK workflows, waypoints, routing and other mesh tools while keeping a consistent No Bars Command interface.

## Product structure

- **COMMAND • MESHTASTIC** — this repository, based on SocialMesh
- **COMMAND • MESHCORE** — `nobarsclubofficial/No-Bars-Connect-MeshCore`, based on the NO BARS PRO work
- **Umbrella product:** **NO BARS COMMAND**
- **Subtitle:** **Off Grid Communications Platform**

The long term goal is one No Bars Command experience with a startup choice between Meshtastic and MeshCore while keeping each protocol separate underneath.

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

SocialMesh is licensed under the GNU General Public License v3.0 or later. No Bars Command preserves the upstream copyright and license notices and makes the corresponding modified source available under the same license terms.

Meshtastic is a separate open source project. Compatibility with Meshtastic does not imply ownership of, endorsement by, or affiliation with the Meshtastic project or its trademarks.

## Hosted service audit

The upstream SocialMesh client contains optional integrations with hosted services such as Firebase, RevenueCat, Stripe and account/cloud features. No Bars Command must not silently depend on upstream production accounts. Those integrations are being audited, disabled, or replaced for the No Bars build while local radio communication and offline functionality are preserved.

## Development direction

The first branded release focuses on:

1. No Bars Command product identity
2. Android and iOS display names, splash screens and icons
3. Website matched dark theme
4. Preserving BLE, USB and local Meshtastic operation
5. Preserving messaging, nodes, maps, telemetry, device configuration and TAK functionality
6. Replacing or disabling upstream hosted service dependencies before public distribution
7. Keeping upstream GPL attribution and source compliance intact

## Build

This remains a Flutter project. Follow the upstream SocialMesh build requirements until No Bars Command specific build documentation is completed.

---

**NO BARS COMMAND**  
*Off Grid Communications Platform*  
A No Bars Club project  
https://www.nobarsclub.com
