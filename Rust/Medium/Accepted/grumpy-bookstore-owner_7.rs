impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut result = 0;
        let mut max = 0;
        let mut temp = 0;
        let mut i = 0;
        let mut j = 0;
        let mut minutes = minutes as usize;
        while i < customers.len() {
            if grumpy[i] == 0 {
                result += customers[i];
            } else {
                temp += customers[i];
            }
            if i - j + 1 == minutes {
                max = max.max(temp);
                if grumpy[j] == 1 {
                    temp -= customers[j];
                }
                j += 1;
            }
            i += 1;
        }
        result + max
    }
}