# Assignment 3 | Bridge Pattern

- **Name:** Baimagambet Gauhar
- **Group:** SE-2530
- **Topic:** B (Notifications)
- **Repository:** https://github.com/gauharb/sdp-asn3
- **Base commit (working I1/I2 version):** 8b744d41e0eb86f75c17779e4d7ff4ec1ca363b8

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | Notification | src/Notification.java |
| A1 | Reminder | src/Reminder.java |
| A2 | UrgentAlert | src/UrgentAlert.java |
| Implementor | Channel | src/Channel.java |
| I1 | EmailChannel | src/EmailChannel.java |
| I2 | SmsChannel | src/SmsChannel.java |
| I3 | PushChannel | src/PushChannel.java |
| Client | Main | src/Main.java |

## Where to look

- Bridge field: `Notification.channel` (private Channel channel)
- `execute()`: `Notification.execute()`
- `setImplementation(...)`: `Notification.setImplementation(Channel)`
- T5 check: `Main.checkSwitch()`

## Build and run

    javac --release 17 -encoding UTF-8 -d out "@sources.txt"
    java -cp out Main --demo

## Expected results

| Check | Setup | Expected result |
|---|---|---|
| T1 | Reminder + EmailChannel | EMAIL delivered: [To: student@astanait.edu.kz \| Subject: Notification r1 \| Body: REMINDER: Submit Assignment 3 by 23:59] |
| T2 | Reminder + SmsChannel | SMS delivered: [SMS] REMINDER: Submit Assignment 3 by 23:59 |
| T3 | UrgentAlert + EmailChannel | EMAIL delivered: [To: student@astanait.edu.kz \| Subject: Notification u1 \| Body: URGENT: Submit Assignment 3 by 23:59] |
| T4 | UrgentAlert + SmsChannel | SMS delivered: [SMS] URGENT: Submit Assignment 3 by 23:59 |
| T5 | Reminder: Email, then switched to SMS | sameObject=true, stateUnchanged=true, before = Email result, after = SMS result |
| T6 | Reminder + PushChannel | PUSH delivered: {title: Notification r1, text: REMINDER: Submit Assignment 3 by 23:59} |
| T7 | UrgentAlert + PushChannel | PUSH delivered: {title: Notification u1, text: URGENT: Submit Assignment 3 by 23:59} |

Final line: `SUMMARY: 7/7 PASS`