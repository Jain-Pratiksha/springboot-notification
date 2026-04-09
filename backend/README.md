# springboot-notification
This repo will help you with a notification project that works with strategy pattern

Eg:

curl --location 'http://localhost:8080/notify/v1/process' \
--header 'Content-Type: application/json' \
--data '{
"channel": "WhatsApp",
"message": "Om Gan Ganpataye Namah"
}'

Output:
200 OK
Notification sent via WhatsApp: Om Gan Ganpataye Namah 