impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut s = String::new();
        for i in num {
            s.push_str(&i.to_string());
        }
        let mut n = s.parse::<i32>().unwrap();
        n += k;
        n.to_string().chars().map(|x| x.to_digit(10).unwrap() as i32).collect()
    }
}