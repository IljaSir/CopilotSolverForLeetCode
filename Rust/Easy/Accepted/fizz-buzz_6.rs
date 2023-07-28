impl Solution {
    pub fn fizz_buzz(n: i32) -> Vec<String> {
        
        let mut result = Vec::new();
        for i in 1..=n {
            if i % 15 == 0 {
                result.push(String::from("FizzBuzz"));
            } else if i % 3 == 0 {
                result.push(String::from("Fizz"));
            } else if i % 5 == 0 {
                result.push(String::from("Buzz"));
            } else {
                result.push(i.to_string());
            }
        }
        result
    }
}