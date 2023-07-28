impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        let mut modu = 1_000_000_007;
        for order in orders {
            let (price, amount, order_type) = (order[0], order[1], order[2]);
            if order_type == 0 {
                while amount > 0 && !sell.is_empty() && price >= sell.peek().unwrap().0 {
                    let (p, a) = sell.pop().unwrap();
                    if amount >= a {
                        amount -= a;
                    } else {
                        sell.push((p, a - amount));
                        amount = 0;
                    }
                }
                if amount > 0 {
                    buy.push((price, amount));
                }
            } else {
                while amount > 0 && !buy.is_empty() && price <= buy.peek().unwrap().0 {
                    let (p, a) = buy.pop().unwrap();
                    if amount >= a {
                        amount -= a;
                    } else {
                        buy.push((p, a - amount));
                        amount = 0;
                    }
                }
                if amount > 0 {
                    sell.push((price, amount));
                }
            }
        }
        let mut ans = 0;
        while !buy.is_empty() {
            ans = (ans + buy.pop().unwrap().1) % modu;
        }
        while !sell.is_empty() {
            ans = (ans + sell.pop().unwrap().1) % modu;
        }
        ans
    }
}