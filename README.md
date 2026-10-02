# Military Armor (NeoForge, Minecraft 1.21.1)

## Сборка jar через GitHub (ничего ставить не нужно)
1. Создай репозиторий на github.com и загрузи в него содержимое этой папки
   (включая скрытую папку .github).
2. Открой вкладку Actions -> «Build mod». Сборка стартует сама после загрузки
   (или нажми Run workflow).
3. Когда появится зелёная галочка, открой запуск и внизу в разделе Artifacts
   скачай militaryarmor-jar. Внутри zip лежит militaryarmor-1.0.0.jar.
4. Положи jar в .minecraft/mods (нужен NeoForge 21.1.x).

## Локальная сборка
JDK 21, затем: gradle wrapper --gradle-version 8.10.2 && ./gradlew build
Тест в игре: ./gradlew runClient
