impl Solution {
    pub fn get_number_of_backlog_orders(orders: Vec<Vec<i32>>) -> i32 {
        
        let mut buy = std::collections::BinaryHeap::new();
        let mut sell = std::collections::BinaryHeap::new();
        let mut count = 0;
        for order in orders {
            if order[2] == 0 {
                while let Some(&x) = sell.peek() {
                    if x > order[0] {
                        break;
                    }
                    let mut p = sell.pop().unwrap();
                    let mut a = p & 0x00000000ffffffff;
                    if a <= order[1] {
                        order[1] -= a;
                    } else {
                        a -= order[1];
                        order[1] = 0;
                        sell.push(p - a);
                    }
                }
                if order[1] > 0 {
                    buy.push(order[0] << 32 | order[1]);
                }
            } else {
                while let Some(&x) = buy.peek() {
                    if x >> 32 < order[0] {
                        break;
                    }
                    let mut p = buy.pop().unwrap();
                    let mut a = p & 0x00000000ffffffff;
                    if a <= order[1] {
                        order[1] -= a;
                    } else {
                        a -= order[1];
                        order[1] = 0;
                        buy.push(p - a);
                    }
                }
                if order[1] > 0 {
                    sell.push(order[0] << 32 | order[1]);
                }
            }
            count = (count + order[1]) % 1000000007;
        }
        count
    }
}