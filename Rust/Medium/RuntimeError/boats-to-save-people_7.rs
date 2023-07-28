impl Solution {
    pub fn num_rescue_boats(people: Vec<i32>, limit: i32) -> i32 {
        
        let mut people = people;
        people.sort();
        let mut left = 0;
        let mut right = people.len() - 1;
        let mut result = 0;
        while left <= right {
            if people[left] + people[right] <= limit {
                left += 1;
                right -= 1;
            } else {
                right -= 1;
            }
            result += 1;
        }
        result
    }
}