# Food Delivery Restaurant

## Question

![](https://i.loli.net/2018/03/16/5aaae3b51dff1.jpg)

## OOD

```
Restaurant
|-- Name
|-- Id
|-- OrderList
|-- Menu
|-- addOrder(): receive the order from app and add order to orderlist
|-- deleteOrder(): delete an order from orderlist
|-- trackOrder(): return food status
|-- changeMenu(): change the menu
|-- addFoodToMenu(): add a new food to menu

User
|-- Name
|-- Id
|-- address
|-- ShoppingCart
|-- WaitingOrders
|-- historyOredrs
|-- creditCard
|-- addFood(): add a food to shoppingCart
|-- deleteFood(): delete a food from shoppingCart
|-- commitOrder(): convert shoppingCart to an order
|-- pay(): pay for the order

Food
|-- Name
|-- Restaurant: each food has one restaurant
|-- price

Order
|-- FoodList
|-- RestaurantList
|-- User
|-- totalPrice

FoodDelieveryApp
|-- Restaurants
|-- Users
|-- Orders
|-- generateOrder(): generate a new order and tell restaurants
|-- cancelOrder(): cancel a valid order and tell restaurants
|-- trackOrder(): tell restaurants return the food status
|-- searchRestaurant(): return restaurants list by name
```

## 小结

这道 OOD 其实强度还好，逻辑很齐全，感觉求完美的话时间可能不太够，应该舍弃一些功能，将主要功能搭建好。Shopping Cart 可以单独提出来。但是感觉写接口会不会花时间会更多呢。