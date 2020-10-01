Pod::Spec.new do |spec|
    spec.name                     = 'mokoCrashReporting'
    spec.version                  = '0.1.0'
    spec.homepage                 = 'https://github.com/icerockdev/moko-crash-reporting'
    spec.source                   = { :git => "https://github.com/icerockdev/moko-crash-reporting.git", :tag => "release/#{spec.version}" }
    spec.authors                  = 'IceRock Development'
    spec.license                  = { :type => 'Apache 2', :file => 'LICENSE.md' }
    spec.summary                  = 'Swift additions to Kotlin/Native library'

    spec.module_name              = "#{spec.name}"
    spec.source_files             = "crash-reporting/src/iosMain/swift/**/*.{h,m,swift}"
    spec.resources                = "crash-reporting/src/iosMain/bundle/**/*"

    spec.ios.deployment_target  = '11.0'
    spec.swift_version = '5.0'

    spec.pod_target_xcconfig = {
        'VALID_ARCHS' => '$(ARCHS_STANDARD_64_BIT)'
    }
end
