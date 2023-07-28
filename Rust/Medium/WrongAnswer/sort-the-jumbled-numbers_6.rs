impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![];
        let mut map = vec![];
        for i in 0..mapping.len() {
            map.push((mapping[i], i));
        }
        map.sort();
        for n in nums {
            let mut str = n.to_string();
            for i in 0..str.len() {
                let c = str.chars().nth(i).unwrap();
                let idx = c.to_digit(10).unwrap() as usize;
                str.replace_range(i..i+1, &map[idx].1.to_string());
            }
            result.push(str.parse::<i32>().unwrap());
        }
        result.sort();
        result
    }
}