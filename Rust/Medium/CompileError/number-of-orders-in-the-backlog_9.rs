impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut sell = std::collections::BinaryHeap::new();
        let mut buy = std::collections::BinaryHeap::new();
        let mut res = 0;
        for order in orders {
            let price = order[0];
            let amount = order[1];
            let order_type = order[2];
            if order_type == 0 {
                while let Some(&[p, a]) = sell.peek() {
                    if p > price {
                        break;
                    }
                    let x = std::cmp::min(a, amount);
                    res -= x;
                    if a > amount {
                        sell.push([p, a - amount]);
                        break;
                    } else {
                        sell.pop();
                    }
                }
                if res < amount {
                    buy.push([-price, amount - res]);
                    res = amount;
                }
            } else {
                while let Some(&[p, a]) = buy.peek() {
                    if p < price {
                        break;
                    }
                    let x = std::cmp::min(a, amount);
                    res -= x;
                    if a > amount {
                        buy.push([p, a - amount]);
                        break;
                    } else {
                        buy.pop();
                    }
                }
                if res < amount {
                    sell.push([price, amount - res]);
                    res = amount;
                }
            }
        }
        (res % 1_000_000_007) as i32
    }
}