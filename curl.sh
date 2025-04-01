#!/bin/bash
URL="http://localhost:8080/persons"

echo -e "\n\n *** Add the first person"
curl -i -X POST -d '{"name":"Александр", "surname": "Александров", "age": 37, "phoneNumber":"+7 987 123 40 50", "cityOfLiving":"Балашиха"}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** Add the second person"
curl -i -X POST -d '{"name":"Борис", "surname": "Борисов", "age": 33, "phoneNumber":"+7 987 123 40 00", "cityOfLiving":"Люберцы"}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** Add the third person"
curl -i -X POST -d '{"name":"Василий", "surname": "Васильев", "age": 19, "phoneNumber":"+7 987 123 00 50", "cityOfLiving":"Мытищи"}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** Add the fourth person"
curl -i -X POST -d '{"name":"Григорий", "surname": "Григорьев", "age": 25, "phoneNumber":"+7 987 123 00 60", "cityOfLiving":"Мытищи"}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** Modify the first person"
curl -i -X POST -d '{"name":"Александр", "surname": "Александров", "age": 37, "phoneNumber":"+7 987 100 00 00", "cityOfLiving":"Реутов"}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** Find by city"
curl -i -G --data-urlencode "city=мытищи" "${URL}/by-city"

echo -e "\n\n *** Find by age"
curl -i -G --data-urlencode "age=28" "${URL}/by-age"

echo -e "\n\n *** Find by name and surname"
curl -i -G --data-urlencode "name=александр" --data-urlencode "surname=александров" "${URL}/by-name"

echo -e "\n\n *** Delete the third person"
curl -i -X DELETE -d '{"name":"Василий", "surname": "Васильев", "age": 19}' -H "Content-Type: application/json" "${URL}"

echo -e "\n\n *** List all persons"
curl -i -X GET "${URL}"

echo -e "\n\n *** Get the first person"
curl -i -G --data-urlencode "name=Александр" --data-urlencode "surname=Александров" --data-urlencode "age=37" "${URL}/by-id"

