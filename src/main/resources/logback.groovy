import ch.qos.logback.classic.Level
import ch.qos.logback.classic.PatternLayout
import com.splunk.logging.HttpEventCollectorLogbackAppender

// index names
def logsIndex = System.getProperty("techlogs.index.name", "filestore")

// Splunk settings
def enableLogToSplunk = System.getProperty("enable.log.to.splunk", "true")
def splunkHost = System.getProperty("splunk.host", "127.0.0.1")
def splunkPort = Integer.valueOf(System.getProperty("splunk.port", "8088"));
def splunkToken = System.getProperty("splunk.token", "faketoken")

println "Splunk logging enabled = [$enableLogToSplunk]"
println "Splunk host = [$splunkHost]"
println "Splunk port = [$splunkPort]"
println "Splunk token = [$splunkToken]"

appender("SplunkAppender", HttpEventCollectorLogbackAppender) {
    url = "http://" + splunkHost + ":" + splunkPort
    token = splunkToken
    sourcetype = "json-escaped"
    index = logsIndex
    layout(PatternLayout) {
        pattern = "%d{MM.dd-HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n"
    }
}

Level level = Level.valueOf("DEBUG");
println "Logging level = [$level]"

root(level, ["SplunkAppender"])