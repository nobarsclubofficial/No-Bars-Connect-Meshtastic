// SPDX-License-Identifier: GPL-3.0-or-later

import 'package:flutter/material.dart';

/// Central No Bars Club brand tokens for the No Bars Connect client.
///
/// Values mirror the live nobarsclub.com visual system so branded screens can
/// migrate away from hard coded SocialMesh colors without scattering new
/// constants throughout the app.
abstract final class NoBarsBrand {
  static const String appName = 'No Bars Connect';
  static const String website = 'https://www.nobarsclub.com';
  static const String protocolLabel = 'Meshtastic';

  static const Color background = Color(0xFF080B0A);
  static const Color panel = Color(0xFF0F1412);
  static const Color panelSecondary = Color(0xFF141B18);
  static const Color text = Color(0xFFEEE9DC);
  static const Color muted = Color(0xFF9AA8A0);
  static const Color accent = Color(0xFF9A6F35);
  static const Color accentSecondary = Color(0xFF7F8F6A);
  static const Color line = Color(0xFF253129);
  static const Color danger = Color(0xFFFF5B67);

  static const Color darkTextOnAccent = Color(0xFF071008);
}
