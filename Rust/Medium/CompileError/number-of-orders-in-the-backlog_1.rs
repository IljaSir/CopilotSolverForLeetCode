impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        for order in orders {
            if order[2] == 0 {
                buy.push((order[0], order[1]));
            } else {
                sell.push((-(order[0] as i64), order[1] as i64));
            }
            while !buy.is_empty() && !sell.is_empty() {
                let (buy_price, buy_amount) = buy.peek().unwrap();
                let (sell_price, sell_amount) = sell.peek().unwrap();
                if *buy_price >= -(*sell_price as i32) {
                    break;
                }
                buy.pop();
                sell.pop();
                if buy_amount > sell_amount {
                    buy.push((*buy_price, buy_amount - sell_amount));
                } else if buy_amount < sell_amount {
                    sell.push((*sell_price, sell_amount - buy_amount));
                }
            }
        }
        let mut result = 0;
        for (_, amount) in buy {
            result = (result + amount) % 1_000_000_007;
        }
        for (_, amount) in sell {
            result = (result + amount) % 1_000_000_007;
        }
        result as i32
    }
}