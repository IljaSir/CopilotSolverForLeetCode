impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        let mut current = 0;
        let minutes = minutes as usize;
        while j < customers.len() {
            if grumpy[j] == 1 {
                current += customers[j];
            } else {
                sum += customers[j];
            }
            j += 1;
            if j - i == minutes {
                if current > max {
                    max = current;
                }
                if grumpy[i] == 1 {
                    current -= customers[i];
                }
                i += 1;
            }
        }
        sum + max
    }
}