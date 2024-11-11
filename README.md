# Симуляция

Пошаговая симуляция 2D-мира, населенного травоядными и хищниками.

## Содержание

- [Стек](#стек)
- [Особенности](#особенности)
- [Пример работы](#Пример)
- [Установка](#установка)

## Стек
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

## Особенности

- Наличие статических объектов, выполняющих роль преград *(деревья🌴, камни🗿)*.
- **Травоядные🦓** питаются *травой🌿*.
- **Хищники🦁** стремятся истребить **Травоядных🦓**.
- Достижение цели основано на поиске в ширину (breadth-first search).
- За 1 ход **Хищник🦁** проходит **1 клетку**, **Травоядный🦓** - **2 клетки**.
- За съедении травы **Травоядный🦓** получает бонус +5 очков здоровья.
- За одну атаку **Хищник🦁** отнимает у **Травоядного🦓** -5 очков здоровья.
- После смерти **Травоядного🦓**, на его месте появляются *кости☠*.
- Если на карте не осталось *травы🌿* или **Травоядных🦓**, они генерируются в случайных клетках.
- Симуляция начинается с случайного заселения карты существами и объектами.
- Минимальный размер карты: **5х5 клеток**.
- Симуляция завершается, когда у существ не получается построить путь к своей цели (**Травоядный🦓** - *трава🌿*,
  **Хищник🦁** - **Травоядный🦓**).

## Пример


## Установка
 Склонируйте репозиторий:
```
git clone https://github.com/Spacier829/Simulation.git
```
Перейдите в корневую папку проекта
```
cd Simulation/src
```

