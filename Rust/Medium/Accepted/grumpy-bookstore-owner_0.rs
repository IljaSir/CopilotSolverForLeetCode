impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..customers.len() {
            if grumpy[i] == 0 {
                sum += customers[i];
            }
        }
        let mut temp = 0;
        for i in 0..customers.len() {
            if grumpy[i] == 1 {
                temp += customers[i];
            }
            if i >= minutes as usize {
                if grumpy[i - minutes as usize] == 1 {
                    temp -= customers[i - minutes as usize];
                }
            }
            if temp > max {
                max = temp;
            }
        }
        sum + max
    }
}