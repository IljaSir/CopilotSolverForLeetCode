impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        for order in orders {
            if order[2] == 0 {
                while order[1] > 0 && !sell.is_empty() {
                    let min = sell.pop().unwrap();
                    if min.0 >= order[0] {
                        let diff = min.1 - order[1];
                        if diff > 0 {
                            sell.push((min.0, diff));
                            break;
                        } else if diff < 0 {
                            order[1] = -diff;
                        } else {
                            break;
                        }
                    } else {
                        sell.push(min);
                        break;
                    }
                }
                if order[1] > 0 {
                    buy.push((order[0], order[1]));
                }
            } else {
                while order[1] > 0 && !buy.is_empty() {
                    let max = buy.pop().unwrap();
                    if max.0 <= order[0] {
                        let diff = max.1 - order[1];
                        if diff > 0 {
                            buy.push((max.0, diff));
                            break;
                        } else if diff < 0 {
                            order[1] = -diff;
                        } else {
                            break;
                        }
                    } else {
                        buy.push(max);
                        break;
                    }
                }
                if order[1] > 0 {
                    sell.push((order[0], order[1]));
                }
            }
        }
        let mut res = 0;
        while !buy.is_empty() {
            res = (res + buy.pop().unwrap().1) % 1_000_000_007;
        }
        while !sell.is_empty() {
            res = (res + sell.pop().unwrap().1) % 1_000_000_007;
        }
        res as i32
    }
}