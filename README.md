Создать небольшое QUIZ-приложения.
Что нужно сделать
На этом этапе вам предоставлен шаблон приложения с логикой, ресурсами и архивом с файлами artifacts.zip. Нужно доработать проект: изменить некоторые параметры, импортировать ресурсы и настроить зависимости.
Придумайте осмысленное название для приложения и измените его app_name в строковых ресурсах.
Установите параметр minSdk так, чтобы он соответствовал версии Android 7.0.
Измените applicationId на вариант, который лучше подходит к названию вашего приложения.
Добавьте актуальную и стабильную версию библиотеки android.material в gradle-зависимости.
Подключите функцию View Binding в проект.
Добавьте новую иконку приложения с помощью конфигуратора иконок.
Измените цвета в основной теме приложения.
Создайте директорию Font, добавьте группу шрифтов Opensans из файла архива и установите этот шрифт для текста в основной теме приложения.
Добавьте два музыкальных WAV-файла из архива в проект. Выберите для этого подходящую директорию.
Добавьте разрешение для подключения «Интернет» в вашем манифест-файле.
Создайте экран приветствия с изображением welcome_picture (представлено в архиве в векторном формате SVG) и кнопкой «Продолжить», не используя Splash Screen API.
Для организации навигации по приложению обязательно используйте библиотеку AndroidX Navigation.
Приложение должно состоять из трёх фрагментов: экрана приветствия, экрана опроса и экрана результатов.
Добавьте в проект три экрана, создайте для них разметку и наполните данными. Используйте стили, темы и ресурсы, которые получились по результатам прошлых модулей.
Экран приветствия должен содержать минимальную информацию (собственно, приветствие), а также кнопку «Начать», которая должна переводить пользователя на следующий экран «Опрос».
Экран опроса должен представлять из себя опросник из трёх вопросов, данные для которого нужно взять из объекта QuizStorage. Если вы скопировали весь проект из модуля “Ресурсы проекта” в папку текущего модуля, то этот объект должен храниться по следующему пути:
Разметку для этого экрана реализуйте с помощью компонента ScrollView, который позволяет пролистывать экран.
Добавьте в ScrollView необходимые View. Получите список вопросов и ответов и установите эти данные в соответствующие View.
При необходимости установите листенеры во View, чтобы иметь возможность обрабатывать ответы на вопросы.
На этом экране также должны быть две кнопки:
«Назад», которая возвращает приложение на стартовый экран.
«Отправить», по нажатию на которую обрабатываются результаты опросника с помощью функции QuizStorage.answer(). Полученный результат нужно отправить в третий экран «Результаты» в качестве аргумента.
Экран Результаты на котором должны быть:
Результат прохождения опросника, который вы передали в предыдущем пункте.
Кнопка «Начать заново», которая открывает новый незаполненный экран с опросником.
Протестируйте ваше приложение. Убедитесь, что результаты опроса вычисляются и передаются на экран результатов.
Поработайте с бэкстеком фрагментов и настройте навигацию по проекту следующим образом:
Экран приветствия, кнопка «Начать»: ведёт на экран опроса.
Экран приветствия, кнопка Back вашего телефона: закрывает приложение.
Экран опроса, кнопка «Назад»: возвращает на экран приветствия.
Экрароса, кнопка Back вашего телефона: также возвращает на экран приветствия.
Экран опроса, кнопка «Отправить»: ведёт на экран результатов, передаются соответствующие результаты.
Экран результатов, кнопка «Начать заново»: ведёт на новый экран опроса, при этом, если на открывшемся экране нажать кнопку Back вашего телефона, приложение не должно возвращаться на экран результатов. Вместо этого должен открываться экран приветствия.
Экран 3, кнопка Back вашего телефона: возвращает на экран приветствия.
Добавьте анимации переходов между фрагментами на экранах «Приветствие», «Опрос», «Результаты». Необходимо добавить минимум две собственные анимации и описать их в xml-файлах. Можете использовать любой фреймворк анимации (animator, animation, transition).
Добавьте анимацию Ripple для кнопки «Начать» на экране «Приветствие».
Добавьте анимацию появления элементов (изменение прозрачности с 0 до 1) для любых элементов на экране «Опрос».
Добавьте любую анимацию минимум для двух элементов на экране результатов при помощи objectAnimator (либо других animator классов). Можете использовать xml- либо kotlin-код для описания анимаций.
Добавьте любую готовую анимацию с помощью Lottie на экран «Результаты».
К предыдущему макету welcome-экрана добавьте кнопку, где попросите пользователя ввести дату его рождения. По нажатию на кнопку покажите DatePicker.
Навесьте на него «слушатель» и считайте введённую дату.
После подтверждения выбора, используя форматтер, преобразуйте дату в человекоориентированный вид, например 03.01.22.
Покажите отформатированную дату в Snackbar (как в примере из видео).
Переведите приложение на английский язык. Для этого создайте отдельную русскую локализацию и добавьте туда все строки на русском языке, а в дефолтной локали переводите все строки на английский язык.
Проверьте, что всё работает корректно. Для этого поменяйте в настройках телефона язык системы.
