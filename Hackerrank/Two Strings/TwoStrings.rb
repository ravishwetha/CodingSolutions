#!/bin/ruby

require 'json'
require 'stringio'

# Complete the twoStrings function below.
def twoStrings(s1, s2)
    s1Hash = {}
    s1.chars.each do |c|
        if !s1Hash[c].nil?
            s1Hash[c] = s1Hash[c] + 1
        else
            s1Hash[c] = 1
        end
    end
    puts s1Hash
    shareSubset = false
    s2.chars.each do |c|
        if !s1Hash[c].nil?
           shareSubset = true
            break
        end
    end
    shareSubset ? 'YES' : 'NO'
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')

q = gets.to_i

q.times do |q_itr|
    s1 = gets.to_s.rstrip

    s2 = gets.to_s.rstrip

    result = twoStrings s1, s2

    fptr.write result
    fptr.write "\n"
end

fptr.close()
