impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        let mut res = 0;
        for order in orders {
            let (price, amount, order_type) = (order[0], order[1], order[2]);
            if order_type == 0 {
                while amount > 0 && !sell.is_empty() && sell.peek().unwrap().0 <= price {
                    let (p, mut a) = sell.pop().unwrap();
                    if a > amount {
                        a -= amount;
                        amount = 0;
                        sell.push((p, a));
                    } else {
                        amount -= a;
                    }
                }
                if amount > 0 {
                    buy.push((price, amount));
                }
            } else {
                while amount > 0 && !buy.is_empty() && buy.peek().unwrap().0 >= price {
                    let (p, mut a) = buy.pop().unwrap();
                    if a > amount {
                        a -= amount;
                        amount = 0;
                        buy.push((p, a));
                    } else {
                        amount -= a;
                    }
                }
                if amount > 0 {
                    sell.push((price, amount));
                }
            }
        }
        while !buy.is_empty() {
            let (_, a) = buy.pop().unwrap();
            res = (res + a) % 1000000007;
        }
        while !sell.is_empty() {
            let (_, a) = sell.pop().unwrap();
            res = (res + a) % 1000000007;
        }
        res
    }
}