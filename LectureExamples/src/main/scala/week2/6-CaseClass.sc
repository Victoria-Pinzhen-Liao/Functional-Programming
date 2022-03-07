case class Book(isbn: String)

val frankenstein = Book("978-0486282114")

case class Message(sender: String, recipient: String, body: String)

val message1 = Message("sender", "recipient", "body: hi")

message1.sender // val res0: String = sender

// this line does not compile
// Error msg:   |Reassignment to val sender
message1.sender = "travis@washington.us"

//-------------------------------

val message2 = Message("sender", "recipient", "body: hi")

message1 == message2 // val res1: Boolean = true

// -------------------------

val message3 = message1.copy(sender = "sender2")
message3 // val res2: Message = Message(sender2,recipient,body: hi)