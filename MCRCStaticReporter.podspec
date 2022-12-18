Pod::Spec.new do |spec|
    spec.name                     = 'MCRCStaticReporter'
    spec.version                  = '0.4.0'
    spec.homepage                 = 'https://github.com/icerockdev/moko-crash-reporting'
    spec.source                   = { :git => "https://github.com/icerockdev/moko-crash-reporting.git", :tag => "release/#{spec.version}" }
    spec.authors                  = 'IceRock Development'
    spec.license                  = { :type => 'Apache 2', :file => 'LICENSE.md' }
    spec.summary                  = 'summary'
    spec.module_name              = "#{spec.name}"

    spec.ios.deployment_target  = '11.0'
    spec.swift_version = '5'
    spec.static_framework = true

    spec.dependency 'FirebaseCrashlytics', '~> 8.2'
    spec.dependency 'MCRCDynamicProxy'

    spec.source_files = "crash-reporting-crashlytics/src/iosMain/swift/StaticReporter/**/*.{h,m,swift}"
end