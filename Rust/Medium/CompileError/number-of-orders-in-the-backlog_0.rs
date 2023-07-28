impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        for order in orders {
            let (price, amount, order_type) = (order[0], order[1], order[2]);
            if order_type == 0 {
                while amount > 0 && !sell.is_empty() && -sell.peek().unwrap().0 >= price {
                    let (sell_price, mut sell_amount) = -sell.pop().unwrap();
                    if sell_amount > amount {
                        sell_amount -= amount;
                        sell.push((-sell_price, sell_amount));
                        amount = 0;
                    } else {
                        amount -= sell_amount;
                    }
                }
                if amount > 0 {
                    buy.push((price, amount));
                }
            } else {
                while amount > 0 && !buy.is_empty() && buy.peek().unwrap().0 <= price {
                    let (buy_price, mut buy_amount) = buy.pop().unwrap();
                    if buy_amount > amount {
                        buy_amount -= amount;
                        buy.push((buy_price, buy_amount));
                        amount = 0;
                    } else {
                        amount -= buy_amount;
                    }
                }
                if amount > 0 {
                    sell.push((-price, amount));
                }
            }
        }
        let mut ans = 0;
        for (_, amount) in buy {
            ans += amount;
            ans %= 1_000_000_007;
        }
        for (_, amount) in sell {
            ans += amount;
            ans %= 1_000_000_007;
        }
        ans as i32
    }
}