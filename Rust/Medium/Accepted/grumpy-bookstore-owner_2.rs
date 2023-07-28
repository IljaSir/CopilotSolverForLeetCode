impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut sum = customers.iter().zip(grumpy.iter()).fold(0, |acc, (c, g)| {
            if *g == 0 {
                acc + c
            } else {
                acc
            }
        });
        let mut max = 0;
        let mut i = 0;
        let mut j = minutes as usize;
        while j <= customers.len() {
            let mut tmp = 0;
            for k in i..j {
                if grumpy[k] == 1 {
                    tmp += customers[k];
                }
            }
            max = max.max(tmp);
            i += 1;
            j += 1;
        }
        sum + max
    }
}