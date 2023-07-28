impl Solution {
    pub fn people_aware_of_secret(n: i32, delay: i32, forget: i32) -> i32 {
        
        let mut people = 1;
        let mut known = 1;
        let mut day = 1;
        let mut forget = forget;
        let mut delay = delay;
        let mut modu = 1000000007;
        while day < n {
            people += known;
            people %= modu;
            day += 1;
            if day == delay {
                known = people;
            }
            if day == forget {
                known -= 1;
                delay += delay;
                forget += forget;
            }
        }
        people
    }
}