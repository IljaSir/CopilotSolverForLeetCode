impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        let mut res = 0;
        for order in orders {
            let price = order[0];
            let amount = order[1];
            let order_type = order[2];
            if order_type == 0 {
                while let Some(s) = sell.pop() {
                    if s.1 <= price {
                        if amount >= s.0 {
                            res = (res + s.0) % 1000000007;
                            amount -= s.0;
                        } else {
                            res = (res + amount) % 1000000007;
                            sell.push((s.0 - amount, s.1));
                            amount = 0;
                        }
                    } else {
                        sell.push(s);
                        break;
                    }
                }
                if amount > 0 {
                    buy.push((amount, price));
                }
            } else {
                while let Some(b) = buy.pop() {
                    if b.1 >= price {
                        if amount >= b.0 {
                            res = (res + b.0) % 1000000007;
                            amount -= b.0;
                        } else {
                            res = (res + amount) % 1000000007;
                            buy.push((b.0 - amount, b.1));
                            amount = 0;
                        }
                    } else {
                        buy.push(b);
                        break;
                    }
                }
                if amount > 0 {
                    sell.push((amount, price));
                }
            }
        }
        res as i32
    }
}