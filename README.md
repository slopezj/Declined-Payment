# Declined-Payment
Requirements
• Please automate a booking up to a declined payment on
• https://www.ryanair.com/ie/en/
• Use any card number and verify the error message.
• Languages, use any one of the following methods:
• Java (maven, junit), Javascript (protractor),Ruby or Python
• Use Page Object Pattern
• Give some documentation on why you chose what you did
• …and documentation on how to run these tests.
• Show reporting for your results
Nice to haves:
• Git - Use a Github account if you have one, to provide the source code
• We are fans of BDD and Cucumber in Ryanair, use these if you can
• The test itself is quite simple, though you should use all your skills to prove your knowledge & ability.
Return Delivery Format
Please use Github if possible, otherwise provide a link to a dropbox account or as a last resort email .zip format of source code (standard zip compression only)
Tests will be reviewed on mac OSX
Contact
connollys@ryanair.com for any questions or clarifications about the test.
Example Test Input
Given I make a booking from “DUB” to “SXF” on 11/03/2016 for 2 adults and 1 child
When I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”
Then I should get payment declined message
