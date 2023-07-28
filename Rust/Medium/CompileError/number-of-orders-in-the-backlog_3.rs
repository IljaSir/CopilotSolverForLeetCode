impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        for order in orders {
            let p = order[0];
            let a = order[1];
            let t = order[2];
            if t == 0 {
                while !sell.is_empty() && sell.peek().unwrap().0 <= p && a > 0 {
                    let (price, amount) = sell.pop().unwrap();
                    if a >= amount {
                        a -= amount;
                    } else {
                        sell.push((price, amount - a));
                        a = 0;
                    }
                }
                if a > 0 {
                    buy.push((p, a));
                }
            } else {
                while !buy.is_empty() && buy.peek().unwrap().0 >= p && a > 0 {
                    let (price, amount) = buy.pop().unwrap();
                    if a >= amount {
                        a -= amount;
                    } else {
                        buy.push((price, amount - a));
                        a = 0;
                    }
                }
                if a > 0 {
                    sell.push((p, a));
                }
            }
        }
        let mut ans = 0;
        while !buy.is_empty() {
            ans = (ans + buy.pop().unwrap().1) % 1000000007;
        }
        while !sell.is_empty() {
            ans = (ans + sell.pop().unwrap().1) % 1000000007;
        }
        ans
    }
}