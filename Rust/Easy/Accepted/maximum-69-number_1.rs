impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut num_str = num.to_string();
        for i in 0..num_str.len() {
            if num_str.get(i..i+1).unwrap() == "6" {
                num_str.remove(i);
                num_str.insert(i, '9');
                break;
            }
        }
        num_str.parse::<i32>().unwrap()
    }
}