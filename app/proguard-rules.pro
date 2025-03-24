# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Keep Java Beans classes required by SnakeYAML
-keep class java.beans.** { *; }
-keep class org.yaml.snakeyaml.** { *; }
-keep class org.yaml.snakeyaml.** { *; }
-keep class org.mozilla.gecko.util.DebugConfig { *; }
-keep class app.gomuks.** { *; }
-keep class org.mozilla.** { *; }
-keepclassmembers class * {
    native <methods>;
}
-dontwarn org.yaml.snakeyaml.LoaderOptions
-dontwarn org.yaml.snakeyaml.TypeDescription
-dontwarn org.yaml.snakeyaml.Yaml
-dontwarn org.yaml.snakeyaml.constructor.BaseConstructor
-dontwarn org.yaml.snakeyaml.constructor.Constructor
-dontwarn org.yaml.snakeyaml.error.YAMLException
-dontwarn kotlin.annotations.jvm.MigrationStatus
-dontwarn kotlin.annotations.jvm.UnderMigration
-dontwarn java.beans.BeanInfo
-dontwarn java.beans.FeatureDescriptor
-dontwarn java.beans.IntrospectionException
-dontwarn java.beans.Introspector
-dontwarn java.beans.PropertyDescriptor