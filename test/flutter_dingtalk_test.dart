import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_dingtalk_sdk/flutter_dingtalk_sdk.dart';

void main() {
  const MethodChannel channel = MethodChannel('flu_dingtalk');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FluDingtalk.openAPIVersion, '42');
  });
}
