//---------------

// Matching on case classes

import week4._

def showNotification(notification: Notification): String = {
  notification match {
    case Email(sender, title, _) =>
      s"You got an email from $sender with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) =>
      s"You received a Voice Recording from $name! Click the link to hear it: $link"
  }
}

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

showNotification(someSms)
// prints You got an SMS from 12345!
// Message: Are you there?

showNotification(someVoiceRecording)
// prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
