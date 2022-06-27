# Unicode Visual Spoofing Demo Program

## Authors
- Jayden Tan
- Rohan Khayech
- Lara Ahmad Salem
- Nelson Li

## About
This demo program highlights how spoofed IDN's using Unicode Visual Spoofing can be distributed on a forum site. 

The master branch contains the vulnerable application, where IDN's are posted in plain-text, allowing users to be vulnerable to spoofing attacks.

The patch branch contains the patched application, which filters all URL's and converts any IDN's to punycode, meaning users can easily tell between a legitimate site and one that uses special unicode characters to appear real.

## How to Run
The program must be run on a Linux system and assumes that JDK 11.0.8 is installed.

To run the main program enter:

    gradle run

To run the app functionality (UnitTestApp) and vulnerability patch (UnitTestConversion) tests enter:
    
    gradle test
    
The app functionality tests should pass on both branches, while the vulnerability patch test should only pass on the patch branch, and fail on the master branch.

## Detection, Exploitation and Patching Vulnerability
To detect the vulnerability, we have checked for common URL prefixes (www.), suffixes (.com, .net etc.) and protocol prefixes (http://, https://) to detect any links posted in the forum.

To exploit the vulnerability, an attacker must simply register and login to an account, and then post a URL containing unicode characters such as an IDN, that make the URL appear similar to a well-known domain. They would then register this unique unicode domain and host a webpage that could either download malware or ask the user to enter sensitive information. Users of the forum site may confuse these visually similar characters and then follow the link without checking their address bar.

To patch the vulnerability we have used java's built in IDN class, passing in any posted URL's to convert any IDN's to punycode URL's. This represents the IDN's in a way that it is clear to the user that a URL is different to a domain they may trust, and the user will then be more likely to exersise caution when/if following the link. Many other languages also provide methods to convert IDN's to punycode.

Users may still use unicode characters to express themselves without conversion if they are not part of a URL.

## License

See LICENSE.
