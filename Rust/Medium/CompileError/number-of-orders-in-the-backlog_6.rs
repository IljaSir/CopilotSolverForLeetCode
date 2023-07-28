impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        let mut ret = 0;
        for order in orders {
            if order[2] == 0 {
                let mut amount = order[1];
                while amount > 0 && !sell.is_empty() && sell.peek().unwrap()[0] <= order[0] {
                    let mut s = sell.pop().unwrap();
                    if s[1] <= amount {
                        amount -= s[1];
                        s[1] = 0;
                    } else {
                        s[1] -= amount;
                        amount = 0;
                        sell.push(s);
                    }
                }
                if amount > 0 {
                    buy.push(vec![order[0], amount]);
                }
            } else {
                let mut amount = order[1];
                while amount > 0 && !buy.is_empty() && buy.peek().unwrap()[0] >= order[0] {
                    let mut b = buy.pop().unwrap();
                    if b[1] <= amount {
                        amount -= b[1];
                        b[1] = 0;
                    } else {
                        b[1] -= amount;
                        amount = 0;
                        buy.push(b);
                    }
                }
                if amount > 0 {
                    sell.push(vec![order[0], amount]);
                }
            }
        }
        for order in buy {
            ret = (ret + order[1]) % 1000000007;
        }
        for order in sell {
            ret = (ret + order[1]) % 1000000007;
        }
        ret
    }
}