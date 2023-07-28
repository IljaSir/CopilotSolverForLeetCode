impl Solution {
    pub fn abbreviate_product(left: i32, right: i32) -> String {
        
        let mut num = 1;
        for i in left..=right {
            num *= i;
        }
        let mut num = num.to_string();
        let mut count = 0;
        while num.ends_with('0') {
            num.pop();
            count += 1;
        }
        let d = num.len();
        if d > 10 {
            format!("{}...{}e{}", &num[..5], &num[d - 5..], count)
        } else {
            format!("{}e{}", num, count)
        }
    }
}