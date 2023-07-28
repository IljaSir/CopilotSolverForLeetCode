impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut base = 0;
        let mut max = 0;
        let mut cur = 0;
        let mut i = 0;
        let mut j = 0;
        while j < customers.len() {
            if grumpy[j] == 0 {
                base += customers[j];
            } else {
                cur += customers[j];
            }
            if j - i + 1 == minutes as usize {
                max = max.max(cur);
                if grumpy[i] == 1 {
                    cur -= customers[i];
                }
                i += 1;
            }
            j += 1;
        }
        base + max
    }
}