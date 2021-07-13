package myDemo2

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class myExample extends Simulation {

	val ramp_users = Integer.getInteger("ramp_users", 5)
	val ramp_duration = Integer.getInteger("ramp_duration", 60)

	val httpProtocol = http
		.baseUrl("https://challenge.flood.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
		.doNotTrackHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Origin" -> "https://challenge.flood.io",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_5 = Map(
		"Accept" -> "*/*",
		"If-None-Match" -> """"7eaba04fa65562f24adc9f393eb36c50"""",
		"X-Requested-With" -> "XMLHttpRequest")

	val th_min = 1
	val th_max = 3

	val scn = scenario("myExample")
		.exec(http("Home Page")
			.get("/")
			.check(regex("""<title>(.+?)</title>""").is("""Flood IO Script Challenge"""))
			.headers(headers_0))
		.pause(th_min, th_max)
		.exec(http("POST Start")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "HrnPrykaOxNU+JkmUIECXyUlKPAtXF84X560N2MaotI=")
			.formParam("challenger[step_id]", "M21BakVmMkZPcTlCSFpxc0M3UjFLQT09LS1tUThrUE81dElKLzh5QkZJS0p2ZXBBPT0=--fa9cb834d2ceff60548a5ccb7ff438971ad62502")
			.formParam("challenger[step_number]", "1")
			.formParam("commit", "Start"))
		.pause(3)
		.exec(http("Post Age")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "HrnPrykaOxNU+JkmUIECXyUlKPAtXF84X560N2MaotI=")
			.formParam("challenger[step_id]", "OXBnakhQdGhhSGZWMWkyV0wxNFVmZz09LS1vbDFGWmZNVkg2emlCYkQzZEdVb2lRPT0=--a4252639615310401ea11cb1ce793a8cafa7a59d")
			.formParam("challenger[step_number]", "2")
			.formParam("challenger[age]", "36")
			.formParam("commit", "Next"))
		.exec(http("Post Largest Value")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "HrnPrykaOxNU+JkmUIECXyUlKPAtXF84X560N2MaotI=")
			.formParam("challenger[step_id]", "WmlhOTRBSno1YnY5VC9DWGFpaDR1Zz09LS1FNlh0MFBlWnlGQ1h6RjZVdUhtZUlnPT0=--c806a235d2f0e73c0c661f365415aa05af793b40")
			.formParam("challenger[step_number]", "3")
			.formParam("challenger[largest_order]", "226")
			.formParam("challenger[order_selected]", "UUJtL0ZpLzB2ZW5IcjFlR21MRG9nZz09LS1YTXJMdC9HTFpEMHhoVUJlSWRzSFVBPT0=--d2a012e7657886c8efefe8442740f9bf2273cd28")
			.formParam("commit", "Next"))
		.pause(1)
		.exec(http("Post Correct Value")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "HrnPrykaOxNU+JkmUIECXyUlKPAtXF84X560N2MaotI=")
			.formParam("challenger[step_id]", "eHBZdXRPLzhGUmhNNTNDT2VRYnBSZz09LS1TekcrbHE4SkI1ZlQ0L0wvcTErTEVBPT0=--8e4c52376d252cbfed730ed779b1f3c4654d6f66")
			.formParam("challenger[step_number]", "4")
			.formParam("challenger[order_4]", "1625900287")
			.formParam("challenger[order_5]", "1625900287")
			.formParam("challenger[order_5]", "1625900287")
			.formParam("challenger[order_12]", "1625900287")
			.formParam("challenger[order_6]", "1625900287")
			.formParam("challenger[order_14]", "1625900287")
			.formParam("challenger[order_7]", "1625900287")
			.formParam("challenger[order_11]", "1625900287")
			.formParam("challenger[order_17]", "1625900287")
			.formParam("challenger[order_12]", "1625900287")
			.formParam("commit", "Next")
			.resources(http("Get value")
			.get("/code")
			.headers(headers_5)))
		.pause(10)
		.exec(http("Post One Time Token")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "HrnPrykaOxNU+JkmUIECXyUlKPAtXF84X560N2MaotI=")
			.formParam("challenger[step_id]", "bDc0SG40aEIrRUFMcVV1QUxBQlk5QT09LS13Sy9QdkVIaWxqai9JcFhsQk8wcFR3PT0=--c9ce26cad4fcb9d9b9289df46cbe5400343efc9e")
			.formParam("challenger[step_number]", "5")
			.formParam("challenger[one_time_token]", "2790123466")
			.formParam("commit", "Next"))

	//setUp(scn.inject(atOnceUsers(5))).protocols(httpProtocol)

	setUp(
		scn.inject(rampUsers(ramp_users) during(ramp_duration))
		).protocols(httpProtocol)
}