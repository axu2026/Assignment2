# Assignment 2

This app is for assignment 2 of CS 501 E1, working with state and automatic recomposition.

1. Compose is declarative because it is able to "declare" how the UI should be and how it should look. The UI does not have to manually be set up with logic to change how it looks, instead it is able to change its appearance through state. As state changes, Compose is tells how a composable should change.
2. State can be stored within a composable by using the **remember** keyword, along with **{ mutableStateOf(...) }**. This tells Compose to store the value into memory during initial composition, and then return it  during subsequent recompositions.
3. Composables that use **remember { mutableStateOf(...) }** are stateful as they hold memory to values, while composables that lack this are stateless. Stateless composables are able to take in unputs and provide an output, but do not need to remember any values.
4. XML has a fixed layout, and thus requires outside view logic to be able to manually change appearance. This can be very complicated or error prone. Compose on the other hand, is able to provide the logic along with the building blocks that make up UI (aka the composables) that can simply take inputs/state and reactively determine how it should look. Thus, Compose is declaractive in nature as one can simply pick what UI elements they need and its starting state.
