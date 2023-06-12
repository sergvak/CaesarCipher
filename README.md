# CaesarCipher
Перша робоча версія програми для шифрування.
Програма шифрує за модифікованим шифром Цезаря. Окрім тексту шифруються деякі спец. символи ('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '). Усі інші символи та цифри залишаються незмінними.

Що вийшло зробити відносно технічного завдання:
- Запуск програми з переданими аргументами (java -jar path/CaesarCipher.jar command filePath key) та через консоль. 
- Програма приймає команди (ENCRYPT, DECRYPT та BRUTE_FORCE).
- Програма працює з  англійським алфавітом.
- Результат роботи програми зберігається у новому файлі та має відповідну примітку ([ ENCRYPTED ], [ DECRYPTED ], [ BRUTE_FORCE, key=значення ]).
- Зміст файлу шифрується модифікованим шифром Цезаря. Шифруються також деякі спец. символи ('.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '). Усі інші символи та цифри залишаються незмінними.
- При шифруванні та дешифруванні зберігається оригінальне форматування тексту.
- В режимі BRUTE_FORCE перебираються усі ключі та шукається в тексті значення " the ". Якщо значення " the " буде знайдено в тексті більше трьох разів, то вважаємо що ключ знайдено.
